import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ENTERPRISE BANKING SIMULATION - JAVA 8 FEATURES
 * * demonstrating:
 * 1. Custom Functional Interfaces for Risk Analysis
 * 2. Complex Stream Pipelines (Filtering, Mapping, Reducing)
 * 3. Grouping and Partitioning of Financial Data
 * 4. Defensive coding with Optionals
 * 5. BigDecimal precision for currency
 */
public class LambdasDemo {

    // ==========================================
    // 1. DOMAIN MODELS (Immutable & Secure)
    // ==========================================

    enum TxnType { CREDIT, DEBIT, TRANSFER, FEE }
    enum TxnStatus { PENDING, PROCESSED, FLAGGED, BLOCKED }

    static class Transaction {
        private final String id;
        private final String accountId;
        private final BigDecimal amount;
        private final TxnType type;
        private final LocalDateTime timestamp;
        private TxnStatus status;

        public Transaction(String id, String accountId, double amount, TxnType type) {
            this.id = id;
            this.accountId = accountId;
            // Banking Rule: Always use BigDecimal string constructor or valueOf to avoid double precision loss
            this.amount = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_EVEN);
            this.type = type;
            this.timestamp = LocalDateTime.now();
            this.status = TxnStatus.PENDING;
        }

        // Getters
        public String getId() { return id; }
        public String getAccountId() { return accountId; }
        public BigDecimal getAmount() { return amount; }
        public TxnType getType() { return type; }
        public TxnStatus getStatus() { return status; }
        
        public void setStatus(TxnStatus status) { this.status = status; }

        @Override
        public String toString() {
            return String.format("[%s] %s | %s | $ %s | %s", 
                timestamp.format(DateTimeFormatter.ISO_LOCAL_TIME), id, type, amount, status);
        }
    }

    // ==========================================
    // 2. CUSTOM FUNCTIONAL INTERFACES
    // ==========================================

    @FunctionalInterface
    interface RiskAnalyzer {
        boolean analyze(Transaction t, BigDecimal limit);
    }

    @FunctionalInterface
    interface AuditLogger {
        void log(String context, List<Transaction> batch);
    }

    // ==========================================
    // 3. MAIN PROCESSING ENGINE
    // ==========================================

    public static void main(String[] args) {
        System.out.println(">>> INITIALIZING BANKING TRANSACTION ENGINE <<<\n");

        // --- A. DATA MOCKING ---
        List<Transaction> txnPool = Arrays.asList(
            new Transaction("TXN_101", "ACC_A", 5000.00, TxnType.CREDIT),
            new Transaction("TXN_102", "ACC_B", 120.50, TxnType.DEBIT),
            new Transaction("TXN_103", "ACC_A", 200000.00, TxnType.TRANSFER), // Suspicious: High Value
            new Transaction("TXN_104", "ACC_C", 5.00, TxnType.FEE),
            new Transaction("TXN_105", "ACC_B", 9900.00, TxnType.CREDIT),
            new Transaction("TXN_106", "ACC_A", 50.00, TxnType.DEBIT),
            new Transaction("TXN_107", "ACC_D", 15000.00, TxnType.TRANSFER),
            new Transaction("TXN_108", "ACC_X", 1000000.00, TxnType.DEBIT) // Suspicious: High Value
        );

        // --- B. DEFENSIVE CODING (PREDICATES) ---
        // Predicates for reusable validation logic
        Predicate<Transaction> isHighValue = t -> t.getAmount().compareTo(new BigDecimal("10000")) > 0;
        Predicate<Transaction> isDebit = t -> t.getType() == TxnType.DEBIT;
        Predicate<Transaction> isCredit = t -> t.getType() == TxnType.CREDIT;
        
        // Chain predicates: Find High Value Debits (Potential Fraud)
        Predicate<Transaction> potentialFraud = isHighValue.and(isDebit);


        // --- C. PROCESSING PIPELINE (STREAMS) ---
        
        // 1. Fraud Detection Pipeline
        System.out.println("--- 1. SECURITY AUDIT (Flagging High Risk) ---");
        List<Transaction> flaggedTxns = txnPool.stream()
            .filter(potentialFraud)
            .peek(t -> {
                t.setStatus(TxnStatus.FLAGGED); // Side-effect: Update status
                System.out.println("ALERT: Flagging Transaction for Review -> " + t.getId());
            })
            .collect(Collectors.toList());


        // 2. Financial Reconciliation (Reduce)
        System.out.println("\n--- 2. RECONCILIATION (Total Volume) ---");
        BigDecimal totalVolume = txnPool.stream()
            .map(Transaction::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add); // Accumulate BigDecimals safely
        
        System.out.println("Total Transaction Volume: $ " + totalVolume);


        // 3. Account Analytics (Grouping & Mapping)
        System.out.println("\n--- 3. ACCOUNT ANALYTICS (Group by Account) ---");
        Map<String, List<Transaction>> txnsByAccount = txnPool.stream()
            .collect(Collectors.groupingBy(Transaction::getAccountId));

        // Calculate net position per account using a downstream collector
        Map<String, BigDecimal> balanceByAccount = txnPool.stream()
            .collect(Collectors.groupingBy(
                Transaction::getAccountId,
                Collectors.mapping(
                    t -> t.getType() == TxnType.DEBIT ? t.getAmount().negate() : t.getAmount(),
                    Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                )
            ));
        
        balanceByAccount.forEach((acc, bal) -> 
            System.out.printf("Account: %-6s | Net Position: $ %s%n", acc, bal));


        // --- D. ADVANCED LAMBDAS (Optional & Custom Interfaces) ---

        System.out.println("\n--- 4. RISK ANALYSIS (Custom Functional Interface) ---");
        
        // Implementing the custom interface via Lambda
        RiskAnalyzer swiftRiskCheck = (t, limit) -> 
            t.getType() == TxnType.TRANSFER && t.getAmount().compareTo(limit) > 0;

        // Using Optional to handle cases where no transaction meets criteria
        Optional<Transaction> highestRiskTransfer = txnPool.stream()
            .filter(t -> swiftRiskCheck.analyze(t, new BigDecimal("100000")))
            .max(Comparator.comparing(Transaction::getAmount));

        // Using ifPresentOrElse (Java 9+) or standard ifPresent
        highestRiskTransfer.ifPresent(t -> 
            System.out.println("CRITICAL: Highest Value Transfer Detected: " + t));


        // --- E. REPORTING GENERATION (Function Composition) ---
        System.out.println("\n--- 5. REPORT GENERATION ---");
        
        Function<Transaction, String> enrichData = t -> t.getId() + "_" + t.getType();
        Function<String, String> formatCsv = s -> "CSV_ROW: " + s;
        
        // Compose functions: enrich -> then format
        Function<Transaction, String> pipeline = enrichData.andThen(formatCsv);

        txnPool.stream()
               .limit(3) // Processing only first 3 for brevity
               .map(pipeline)
               .forEach(System.out::println);
    }
}
