import javax.swing.JOptionPane;

/**
 * Programa que solicita al usuario la cantidad de conos a crear, luego pide la base y altura de cada cono,
 */
public class Main {
    public static void main(String[] args) {
        int cantidadConos = solicitarEnteroPositivo("Cuantos conos desea crear?");
        if (cantidadConos == -1) {
            return;
        }

        Cono[] conos = solicitarConos(cantidadConos);
        if (conos == null) {
            return;
        }

        ordenarPorVolumenDescendente(conos);
        imprimirResultados(conos);
    }

    /**
     * Solicita al usuario los parametros de cada cono y los crea.
     * @param cantidadConos
     * @return
     */

    private static Cono[] solicitarConos(int cantidadConos) {
        Cono[] conos = new Cono[cantidadConos];

        for (int i = 0; i < cantidadConos; i++) {
            float base = solicitarParametro("Ingrese la base del cono " + (i + 1) + ":");
            if (base == -1f) {
                return null;
            }

            float altura = solicitarParametro("Ingrese la altura del cono " + (i + 1) + ":");
            if (altura == -1f) {
                return null;
            }

            conos[i] = new Cono(base, altura);
        }

        return conos;
    }

    /**
     * Método para ordenar los conos
     * @param conos
     */
    private static void ordenarPorVolumenDescendente(Cono[] conos) {
        for (int i = 0; i < conos.length - 1; i++) {
            for (int j = 0; j < conos.length - 1 - i; j++) {
                if (conos[j].calcularVolumen() < conos[j + 1].calcularVolumen()) {
                    Cono otro = conos[j];
                    conos[j] = conos[j + 1];
                    conos[j + 1] = otro;
                }
            }
        }
    }

    /**
     * Método para imprimir los resultados en consola y en un mensaje emergente
     * @param conos
     */

    private static void imprimirResultados(Cono[] conos) {
        StringBuilder resultado = new StringBuilder();
        resultado.append("Conos ordenados de mayor a menor por volumen:\n\n");

        for (int i = 0; i < conos.length; i++) {
            Cono cono = conos[i];
            resultado.append("Cono ").append(i + 1)
                    .append(" -> Base: ").append(String.format("%.2f", cono.getBase()))
                    .append(", Altura: ").append(String.format("%.2f", cono.getAltura()))
                    .append(", Area: ").append(String.format("%.2f", cono.calcularAreaBase()))
                    .append(", Volumen: ").append(String.format("%.2f", cono.calcularVolumen()))
                    .append("\n");
        }

        System.out.print(resultado);
        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    /**
     * Método para solicitar un numero entero positivo al usuario, con validación y manejo de cancelación
     * @param mensaje
     * @return
     */
    private static int solicitarEnteroPositivo(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) {
                return -1;
            }

            try {
                int valor = Integer.parseInt(entrada.trim());
                if (valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero entero valido.");
            }

            JOptionPane.showMessageDialog(null, "Ingrese un numero entero positivo.");
        }
    }

    /**
     * Método para solicitar parámetros de base y altura
     * @param mensaje
     * @return
     */

    private static float solicitarParametro(String mensaje) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) {
                return 0;
            }

            try {
                float valor = Float.parseFloat(entrada.trim());
                if (valor > 0) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero valido.");
            }

            JOptionPane.showMessageDialog(null, "Ingrese un numero positivo.");
        }
    }
}

