package br.digital.com

class Aluno(var nome: String, var sobrenome: String, var codigoAluno: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Aluno

        if (codigoAluno != other.codigoAluno) return false

        return true
    }

}