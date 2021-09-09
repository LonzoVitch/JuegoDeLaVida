
package juegodelavida;


public class Simulacion {
    
    int ancho;
    int largo;
    int[][] tablero;

    public Simulacion(int ancho, int largo) {
        this.ancho = ancho;
        this.largo = largo;
      
        this.tablero = new int[ancho][largo];
    }

    public void printTablero() {
        System.out.println("Nueva");
        for (int y = 0; y < largo; y++) {
            String line = "|";
            for (int x = 0; x < ancho; x++) {
                if (this.tablero[x][y] == 0) {
                    line += " M ";
                } else {
                    line += " V ";
                }
            }
            line += "|";
            System.out.println(line);
        }
        System.out.println("Fin\n");
    }

    public void setVivo(int x, int y) {
        this.tablero[x][y] = 1;
    }

    public void setMuerto(int x, int y) {
        this.tablero[x][y] = 0;
    }

    public int contarVecinosVivos(int x, int y) {
        int count = 0;

        count += obtenerEstado(x - 1, y - 1);
        count += obtenerEstado(x, y - 1);
        count += obtenerEstado(x + 1, y - 1);

        count += obtenerEstado(x - 1, y);
        count += obtenerEstado(x + 1, y);

        count += obtenerEstado(x - 1, y + 1);
        count += obtenerEstado(x, y + 1);
        count += obtenerEstado(x + 1, y + 1);

        return count;
    }

    public int obtenerEstado(int x, int y) {
        if (x < 0 || x >= ancho) {
            return 0;
        }

        if (y < 0 || y >= largo) {
            return 0;
        }

        return this.tablero[x][y];
    }

    public void step() {
        int[][] newTablero = new int[ancho][largo];

        for (int y = 0; y < largo; y++) {
            for (int x = 0; x < ancho; x++) {
                int vecinosVivos = contarVecinosVivos(x, y);
                if (obtenerEstado(x, y) == 1) {
                    if (vecinosVivos < 2) {
                        newTablero[x][y] = 0;
                    } else if (vecinosVivos == 2 || vecinosVivos == 3) {
                       
                        newTablero[x][y] = 1;
                    } else if (vecinosVivos > 3) 
                    {
                        newTablero[x][y] = 0;
                    }
                } else {
                    if (vecinosVivos == 3) {
                        newTablero[x][y] = 1;
                    }
                }

            }
        }

        this.tablero = newTablero;
    }

    public static void main(String[] args) {
        Simulacion simulacion = new Simulacion(10, 10);

        simulacion.setVivo(2, 3);
        simulacion.setVivo(1, 4);
        simulacion.setVivo(5, 5);
        simulacion.setVivo(3, 3);
        simulacion.setVivo(2, 4);
        simulacion.setVivo(2, 4);
      

        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();
        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();
        simulacion.printTablero();
        simulacion.step();
        simulacion.printTablero();

       


    }

}
