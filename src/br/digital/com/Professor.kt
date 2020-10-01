package br.digital.com

open class Professor(var nomeProfessor: String, var sobrenomeProfessor: String, var tempoCasa: Int, var codigoProfessor: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Professor

        if (codigoProfessor != other.codigoProfessor) return false

        return true
    }

    override fun toString(): String {
        return "Professor(nome='$nomeProfessor')"
    }


}