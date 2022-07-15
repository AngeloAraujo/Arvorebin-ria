package ArvoreBi;

import aula02_listalineares.ListaEncadeada;

public class Main {

	public static void main(String[] args) {

		ArvoreBinaria arvore = new ArvoreBinaria();
		ListaEncadeada lista = new ListaEncadeada(0);
		
		arvore.inserir(8);
		arvore.inserir(9);
		arvore.inserir(3);
		arvore.inserir(4);
		arvore.inserir(10);
		arvore.inserir(7);
		arvore.inserir(6);
		
		arvore.mostrarEmOrdem();
		
		arvore.remover(3);
		arvore.remover(6);
		System.out.println("�rvore ap�s remo��es");
		arvore.mostrarEmOrdem();
		arvore.mostraraltura();
		arvore.mostrarNos();
		arvore.mostrarfolhas();
		arvore.mostrarmaxmin();
		arvore.ascendentes();
		arvore.descendentes();
		arvore.mostrarDireita();
		arvore.mostrarEsquerda();
		
		System.out.println("Transforma��o da arvore em um lista encadeada: ");
		lista=(arvore.mostrarListaEncadeada());
		System.out.println(lista.mostraLista());
		arvore.mostrarPar();
	}

}
