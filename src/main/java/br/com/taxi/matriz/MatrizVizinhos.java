package br.com.taxi.matriz;

public class MatrizVizinhos {

	enum Vizinho {
		TOP {
			public Posicao apply(int x, int y) {
				return new Posicao(x - 1, y);
			}
		},
		TOPLEFT {
			public Posicao apply(int x, int y) {
				return new Posicao(x - 1, y - 1);
			}
		},
		LEFT {
			public Posicao apply(int x, int y) {
				return new Posicao(x, y - 1);
			}
		},
		BOTTOMLEFT {
			public Posicao apply(int x, int y) {
				return new Posicao(x + 1, y - 1);
			}
		},
		BOTTOM {
			public Posicao apply(int x, int y) {
				return new Posicao(x + 1, y);
			}
		},
		RIGHTBOTTOM {
			public Posicao apply(int x, int y) {
				return new Posicao(x + 1, y + 1);
			}
		},
		RIGHT {
			public Posicao apply(int x, int y) {
				return new Posicao(x, y + 1);
			}
		},
		TOPRIGTH {
			public Posicao apply(int x, int y) {
				return new Posicao(x - 1, y + 1);
			}
		}
		;

		public abstract Posicao apply(int x, int y);
	}

}
