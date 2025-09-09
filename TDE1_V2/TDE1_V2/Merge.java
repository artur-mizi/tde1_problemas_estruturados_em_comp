import java.util.Scanner;

public class Merge {
    public static int[] merge_vetor(int[] vetor_a, int tamanho_a, int[] vetor_b, int tamanho_b) {
        int tamanho_total = tamanho_a + tamanho_b;
        int[] vetor_c = new int[tamanho_total];
        int contador_a = 0, contador_b = 0;
        for (int i = 0; i < tamanho_total; i++) {
            // consertar indice invalido
            if (contador_a == tamanho_a) {
                vetor_c[i] = vetor_b[contador_b];
                contador_b++;
            } else if (contador_b == tamanho_b) {
                vetor_c[i] = vetor_a[contador_a];
                contador_a++;
            } else if (vetor_a[contador_a] <= vetor_b[contador_b]) {
                vetor_c[i] = vetor_a[contador_a];
                contador_a++;
            } else if (vetor_b[contador_b] <= vetor_a[contador_a]) {
                vetor_c[i] = vetor_b[contador_b];
                contador_b++;
            }
        }

        return vetor_c;
    }

    public static Fila merge_lista(Fila fila_a, Fila fila_b) {
        Fila fila_c = new Fila();
        Node atual_a = fila_a.getInicio();
        Node atual_b = fila_b.getInicio();

        while (atual_a != null || atual_b != null) {
            if (atual_a == null) {
                fila_c.inserir(atual_b.getInformacao());
                atual_b = atual_b.getProximo();
            } else if (atual_b == null) {
                fila_c.inserir(atual_a.getInformacao());
                atual_a = atual_a.getProximo();
            } else if (atual_a.getInformacao() <= atual_b.getInformacao()) {
                fila_c.inserir(atual_a.getInformacao());
                atual_a = atual_a.getProximo();
            } else {
                fila_c.inserir(atual_b.getInformacao());
                atual_b = atual_b.getProximo();
            }
        }

        return fila_c;
    }

    public static void exe_lista() {
        Scanner scanner = new Scanner(System.in);
        Fila fila_a = new Fila();
        Fila fila_b = new Fila();
        System.out.println("Digite valores para a fila A (digite 0 para parar):");
        int item;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) break;
            fila_a.inserir(item);
        }
        System.out.println("Digite valores para a fila B (digite 0 para parar):");
        while (true) {
            item = scanner.nextInt();
            if (item == 0) break;
            fila_b.inserir(item);
        }
        Fila fila_c = merge_lista(fila_a, fila_b);
        System.out.print("Fila C: "); fila_c.imprime();
    }

    public static void exe_vetor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do vetor A: ");
        int tamanho_a = scanner.nextInt();
        int[] vetor_a = new int[tamanho_a];
        int contador_a = 0;
        System.out.println("Digite valores para o vetor A:");
        while (contador_a < tamanho_a) { 
            vetor_a[contador_a] = scanner.nextInt();
            contador_a++;
        }

        System.out.print("Digite o tamanho do vetor B: ");
        int tamanho_b = scanner.nextInt();
        scanner.nextLine();
        int[] vetor_b = new int[tamanho_b];
        int contador_b = 0;
        System.out.println("Digite valores para o vetor B:");
        while (contador_b < tamanho_b) { 
            vetor_b[contador_b] = scanner.nextInt();
            contador_b++;
        }

        int[] vetor_c = merge_vetor(vetor_a, tamanho_a, vetor_b, tamanho_b);
        int tamanho_total = tamanho_a + tamanho_b;
        System.out.print("Vetor C: ");
        for (int i = 0; i < tamanho_total - 1; i++) {
            System.out.print(vetor_c[i] + ", ");
        }
        System.out.print(vetor_c[tamanho_total-1]);
    }
    
    
    public static void main(String[] args) {
        // Comentar uma das linhas a seguir para testes
        //exe_vetor();
        exe_lista();
    }
}
