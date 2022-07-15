package ArvoreBi;

import java.util.Scanner;

import ArvoreBi.ArvoreBinaria.Nodo;
import aula02_listalineares.ListaEncadeada;

public class ArvoreBinaria {
	
	Scanner entrada = new Scanner(System.in);
	
	public class Nodo{
		private int dado;
		private Nodo esq, dir;
		
		public Nodo (int dado) {
			this.dado = dado;
			dir=esq= null;
		}
	}
	
	Nodo raiz;
	
	public ArvoreBinaria() {
		raiz= null;
	}
	
	public void inserir (int dado) {
		raiz= inserirDado(raiz, dado);
			
	}
	
	private Nodo inserirDado (Nodo raiz, int dado) {
		if (raiz ==null) {
			raiz = new Nodo(dado);
			return raiz;
		}
		if (dado<raiz.dado)
			raiz.esq= inserirDado(raiz.esq, dado);
		else if (dado>raiz.dado)
			raiz.dir= inserirDado(raiz.dir, dado);
		
		return raiz;
	}
	
		
	public void remover (int dado) {
		raiz = removerDado (raiz,dado);
	}
	
	public Nodo removerDado(Nodo raiz, int dado) {
	Nodo aux1, aux2;
		if (raiz.dado == dado) {
			if (raiz.esq == null && raiz.dir == null){
				return null;
				// o elemento não tem filhos
			}else if ( raiz.esq == null) {
				return raiz.dir;
			// o elemento a ser removido não tem filho a esquerda
			} else if (raiz.dir == null) {
				return raiz.esq;
				// o elemento a ser removido não tem filho a esquerda
			}
			else {
			// o elemento a ser removido tem filhos em ambos os lados
				aux1 = raiz.dir;
				aux2 = raiz.dir;
				while (aux1.esq != null) {
					aux1= aux1.esq;
				}
				aux1.esq = raiz.esq;
				return raiz.dir;
			}
		}
	
		else if (raiz.dado< dado)
			raiz.dir= removerDado(raiz.dir, dado);
		else
			raiz.esq = removerDado(raiz.esq, dado);
		
		
		return raiz; 
		
		}
	 
		  
		  public void mostrarEmOrdem () {
				mostrandoOrdenado(raiz);
			}
			
			private void mostrandoOrdenado(Nodo raiz) {
				if (raiz!= null) {
					mostrandoOrdenado(raiz.esq);
					System.out.println(raiz.dado);
					mostrandoOrdenado(raiz.dir);
				}
			}
			
			  public void mostrarmaxmin() {
					if(raiz!= null) {
						System.out.println("Maior valor: "+ max().dado);
						System.out.println("Menor valor "+ min ().dado);
					}
				}
				  
		public Nodo min() {
		    Nodo aux = raiz;
		    Nodo aux2 = null;
				    
		while (aux != null) {
		    aux2 = aux;
		    aux = aux.esq;
		}
		    return aux2;
		}

		public Nodo max() {
		    Nodo aux = raiz;
		    Nodo aux2 = null;
		while (aux != null) {
		    aux2 = aux;
		    aux = aux.dir;
		}
		    return aux2;
		}
			public void mostraraltura() {
				System.out.println("Altura da arvore:"+altura(raiz));	
			}
		  
		  private int altura(Nodo raiz) {
			  Nodo aux = raiz;
		     if(aux == null || (aux.esq == null && aux.dir == null))
		       return 0;
		     else {
		   	if (altura(aux.esq) > altura(aux.dir))
		   	   return  ( 1 + altura(aux.esq) );
		   	else
			   return ( 1 + altura(aux.dir) );
		     }
		  }
		  
		  public void mostrarNos() {
				System.out.println("Quantidade de elementos na lista: "+contarNos(raiz));	
				}
			  
		  public int contarNos(Nodo raiz) {
			   Nodo aux = raiz;
			   if(aux == null) 
				   return 0;
			   else 
				   return ( 1 + contarNos(aux.esq) + contarNos(aux.dir));
		  }
		  
		  public void mostrarfolhas() {
			  System.out.println("Folhas da Arvores: ");
			  folhas(raiz);	
				}
		  
		  private void folhas(Nodo raiz) {  
		    if(raiz == null) {
		    	return;
		    	}
		    if(raiz.esq == null && raiz.dir == null) {
		    	System.out.println(raiz.dado);
		    }
		   folhas(raiz.esq) ;
		   folhas(raiz.dir);
		  
		  }
		  
		 public void ascendentes() {
			 if (raiz!= null) {
				 System.out.println("Insira o dado para mostrar os seus ascendentes: ");
				 int dado = entrada.nextInt();
				 mostrarAscendentes(raiz, dado);
			 }
		}

		 public void mostrarAscendentes(Nodo raiz, int dado) {
			
			 if (raiz.dado>dado) {
				 if(raiz!= null) {
					 System.out.println(raiz.dado);
					 mostrarAscendentes(raiz.esq, dado);
					
				 }
			}else if (raiz.dado<dado) {
					 if (raiz!=null) {
						 System.out.println(raiz.dado);
						 mostrarAscendentes(raiz.dir, dado);
						
					 }
				 }
			 }
			
		 

		 public void descendentes() {
			 System.out.println("Insira o dado para descobrir os seus descendentes:");
			 	int dado = entrada.nextInt();
				mostraDescendentes(raiz, dado, false);
			}

			private void mostraDescendentes(Nodo raiz, int dado, boolean nodoDado) {
				if (raiz == null) return;
					if (nodoDado)
					System.out.println(raiz.dado);
				
				if (raiz.dado == dado) 
					nodoDado = true;
				mostraDescendentes(raiz.esq, dado, nodoDado);
				mostraDescendentes(raiz.dir, dado, nodoDado);
			}
			
		 public void mostrarPar() {
			 System.out.println("Os números pares da sequência é: ");
				mostrandoPares(raiz);

			}
			
			private void mostrandoPares(Nodo raiz) {
				if (raiz != null) {
					if(raiz.dado % 2 == 0) {
					System.out.println(raiz.dado);
					}
					mostrandoPares(raiz.esq);
					mostrandoPares(raiz.dir);
				}
			}
		
		public void mostrarDireita() {
			System.out.println("Insira o valor para descobrir a Subarvore da direita: ");
			int dado = entrada.nextInt();
				mostrandoDireita(raiz,dado);

			}

			private void mostrandoDireita(Nodo raiz, int dado) {
				if (raiz.dado == dado) {
					mostrandoOrdenado(raiz.dir);
				}
				
				if(raiz.dir != null) {
					mostrandoDireita(raiz.dir, dado);
				}
				
				if(raiz.esq != null) {
					mostrandoDireita(raiz.esq, dado);
				}
			}
			
			
			
			public void mostrarEsquerda() {
			System.out.println("Insira o valor para descobrir a Subarvore da esquerda: ");
				int dado = entrada.nextInt();
				mostrandoSubEsquerda(raiz,dado);

			}

			private void mostrandoSubEsquerda(Nodo raiz, int dado) {
				if (raiz.dado == dado) {
					mostrandoOrdenado(raiz.esq);
				}
				
				if(raiz.dir != null) {
					mostrandoSubEsquerda(raiz.dir, dado);
				}
				
				if(raiz.esq != null) {
					mostrandoSubEsquerda(raiz.esq, dado);
				}
			}
			
			public ListaEncadeada mostrarListaEncadeada() {
				ListaEncadeada lista = new ListaEncadeada(raiz.dado);
				transformacao(raiz.esq, lista); 
				transformacao(raiz.dir, lista);
				return lista; 
			}
			
			private void transformacao (Nodo raiz, ListaEncadeada arvore){
				if (raiz ==null) {
					return;
				}
				arvore.inseririnicio(raiz.dado);
				transformacao(raiz.esq, arvore);
				transformacao(raiz.dir, arvore);
				
		 }
		}
		
	
	

