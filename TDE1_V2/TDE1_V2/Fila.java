import java.util.Scanner;

public class Fila {
    private Node inicio;
    private Node fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public Node getInicio() {
        return this.inicio;
    }

    public void inserir(int informacao) {
        Node no = new Node();
        no.setInformacao(informacao);

        if (fim != null) {
            fim.setProximo(no);
        } else {
            inicio = no;
        }
        fim = no;
    }

    public int remover() {
        if (vazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        int valor = inicio.getInformacao();
        inicio = inicio.getProximo();

        if (inicio == null) {
            fim = null;
        }
        return valor;
    }

    public boolean vazia() {
        return inicio == null;
    }

    public void imprime() {
        if (vazia()) {
            System.out.println("Fila vazia");
            return;
        }

        System.out.print("Início -> ");
        Node atual = inicio;
        while (atual != null) {
            System.out.print(atual.getInformacao() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();

        System.out.println("Digite valores para a fila (digite 0 para parar):");
        int item;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) break;
            fila.inserir(item);
        }

        fila.imprime();

        System.out.println("Removendo elemento do início: " + fila.remover());
        fila.imprime();
    }
}
