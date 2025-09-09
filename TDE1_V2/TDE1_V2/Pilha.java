import java.util.Scanner;

public class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }

    public void inserir(int informacao) {
        Node no = new Node();
        no.setInformacao(informacao);
        no.setProximo(topo);
        topo = no;
    }

    public int remover() {
        if (vazia()) {
            throw new IllegalStateException("Pilha vazia");
        }
        int valor = topo.getInformacao();
        topo = topo.getProximo();
        return valor;
    }

    public boolean vazia() {
        return topo == null;
    }

    public void imprime() {
        Node atual = topo;
        System.out.print("Topo -> ");
        while (atual != null) {
            System.out.print(atual.getInformacao() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();

        System.out.println("Digite valores para a pilha (digite 0 para parar):");
        int item;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) break;
            pilha.inserir(item);
        }

        pilha.imprime();

        System.out.println("Removendo elemento do topo: " + pilha.remover());
        pilha.imprime();
    }
}
