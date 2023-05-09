package br.ewefernandes.setint;

public class SetListaInt {
	No primeiro;
	
	public SetListaInt() {
		primeiro = null;
	}
	
	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addFirst(int valor) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}
	
	public void addLast(int valor) throws Exception {
		int tamanho = size();
		int valorLista = 0;
		int seExisteLista = 0;
		
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		} 
		
		for (int i = 0; i < tamanho; i ++) {
			valorLista = get(i);
			if (valorLista == valor) {
				seExisteLista = 1;
			}
		}
		
		if (seExisteLista != 1) {
			No elemento = new No();
			elemento.dado = valor;
			elemento.proximo = null;
			
			No ultimo = getNo(tamanho - 1);
			ultimo.proximo = elemento;
		} else {
			throw new Exception("Valor já está na lista");
		}
		
	}
	
	public void add(int valor, int pos) throws Exception {
		int tamanho = size();
		int seExisteLista = 0;
		int valorLista = 0;
		
		if (pos < 0 || pos > tamanho) {
			throw new Exception("Posição Inválida");
		}
		
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		if (pos == 0) {
			addFirst(valor);
		} else if (pos == tamanho) {
			addLast(valor);
		} else {
	
			for (int i = 0; i < tamanho; i ++) {
				valorLista = get(i);
				if (valorLista == valor) {
					seExisteLista = 1;
				}
			}
			
			if (seExisteLista != 1) {
				No elemento = new No();
				elemento.dado = valor;
				No anterior = getNo(pos - 1);
				elemento.proximo = anterior.proximo;
				anterior.proximo = elemento;
			} else {
				throw new Exception("Valor já está na lista");
			}
		}
		
	}

	private int size() {
		int cont = 0;
		if (!isEmpty()) {
			No auxiliar = primeiro;
			while (auxiliar != null) {
				auxiliar = auxiliar.proximo;
				cont++;
			}
		}
		return cont;
	}
	
	public int get(int pos) throws Exception {
		
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		int tamanho = size();
		
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		int valor = auxiliar.dado;
		return valor;
	}
	
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}
	
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		No penultimo = getNo(tamanho - 2);
		penultimo.proximo = null;
	}

	public void remove(int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Inválida");
		}
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		
		if (pos == 0) {
			removeFirst();
		} else {
			No atual = getNo(pos);
			No anterior = getNo(pos - 1);
			anterior.proximo = atual.proximo;
		}
	}
	
	private No getNo(int pos) throws Exception {
		if (pos < 0) {
			throw new Exception("Posição Inválida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		try {
			int tamanho = size();
			for (int i = 0 ; i < tamanho ; i++) {
				buffer.append("[ ");
				buffer.append(get(i));
				buffer.append(" ]");
				buffer.append("[]->");
				if (i == tamanho - 1) {
					buffer.append("NULL");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
}
