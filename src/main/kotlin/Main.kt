class Persona(var weight: Double, var height: Double) {
    var name: String = ""


    constructor(name: String, weight: Double, height: Double) : this(weight, height) {
        this.name = name
    }


    var imc: Double = 0.0

    init {

        //this.imc =  weight / (height * height)
    }

    fun saludar() {
        println("¡Hola! Soy ${this.name}.")
    }

    fun obtenerImc(): String {

        this.imc = this.weight / (this.height * this.height)
        return "%.2f".format(this.imc)
    }

    fun obtenerImcDesc(): String {
        return when {
            //*Nota: Si el IMC es menos de 18.5, se encuentra dentro del rango de "peso insuficiente".
            // Si el IMC está entre 18.5 y 24.9, se encuentra dentro del rango de "peso saludable".
            // Si el IMC está entre 25.0 y 29.9, se encuentra dentro del rango de "sobrepeso".
            // Si el IMC es 30.0 o superior, se encuentra dentro del rango de "obesidad".

            this.imc < 18.5 -> "insuficiente"
            this.imc in 18.5..24.9 -> "saludable"
            this.imc in 25.0..29.9 -> "sobrepeso"
            this.imc > 30.0 -> "obesidad"
            else -> ""
        }

    }

    fun mostrarDesc() {

        println("El imc de ${this.name} es ${this.obtenerImc()} (${this.obtenerImcDesc()}) teniendo en cuenta que pesa ${this.weight}kg y mide ${this.height}m.\n_____")

    }
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val persona1 = Persona("Alberto", 86.0, 1.74)
    val persona2 = Persona("Sebas", 100.0, 1.71)
    val persona3 = Persona("Sergio", 90.0, 1.72)
    val persona4 = Persona("PacoGenshiner", 81.0, 1.73)
    val persona5 = Persona("LaraKpoper", 87.0, 1.71)
    val persona6 = Persona("MarioEuropopMaster", 80.0, 1.72)
    val persona7 = Persona("PokeTRNRRaúl", 82.0, 1.70)

    val listaPersonas = arrayOf(persona1, persona2, persona3, persona4, persona5, persona6, persona7)


    println("Persona 1, actualice su nombre: ")
    persona1.name = readln()
    println("Su nuevo nombre es: ${persona1.name}")

    listaPersonas.forEach {
        it.saludar()
        it.mostrarDesc()
    }

    println("_____________________________")
}