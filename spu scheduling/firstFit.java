public class firstFit {
    public static void main(String[] args) {
        int blockSize[] = { 100, 500, 200, 300, 600 };
        int processSize[] = { 212, 417, 112, 426 };
        int m = blockSize.length;
        int n = processSize.length;

        int allocation[] = new int[n];

        for (int i = 0; i < n; i++) {
            allocation[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }

        System.out.format("%15s%15s%15s\n", "processNo", "processSize", "blockNo");
        for (int i = 0; i < n; i++) {
            System.out.format("%15d%15d", (i + 1), processSize[i]);
            if (allocation[i] != -1) {
                System.out.format("%15d\n", (allocation[i] + 1));
            } else {
                System.out.format("%15s\n", "not allocated");
            }

        }
    }
}