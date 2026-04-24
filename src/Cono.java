
/**
 * Representa un cono definido por una base circular y una altura
 */
public class Cono {
    private float base;
    private float altura;

    /**
     * Construye un cono a partir de su base circular y sus propiedades.
     *
     * @param r radio de la base
     * @param h altura del cono
     */
    public Cono(float r, float h) { // constructor
        this.base = r;
        this.altura = h;
    }

    /**
     *
     * @param otroCono
     * @return
     */

    /**
     * Calcula el area de la base circular del cono.
     *
     * @return area de la base circular
     */

    public float calcularAreaBase() {
        return (float) 3.14 * base * base;
    }

    /**
     * Calcula el volumen del cono
     *
     * @return el volumen
     */
    public float calcularVolumen() {
        return (float) (1.0 / 3.0 * calcularAreaBase() * altura);
    }

    /**
     *
     * @return base
     */
    public float getBase() {
        return base;
    }

    /**
     *
     * @param base
     */

    public void setBase(float base) {
        this.base = base;
    }

    /**
     *
     * @return altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     *
     * @param altura
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     *
     * @return representacion en cadena del cono
     */
    @Override
    public String toString() {
        return "Cono{" +
                "base=" + base +
                ", altura=" + altura +
                '}';
    }
}

