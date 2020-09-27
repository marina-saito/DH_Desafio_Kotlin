package br.digital.com

class Curso(
        var nomeCurso: String,
        var codigoCurso: Int,
        var professorTitular: ProfessorTitular,
        var professorAdjunto: ProfessorAdjunto,
        var maxAlunos: Int,
        var listaAlunos: MutableList<Aluno>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigoCurso != other.codigoCurso) return false

        return true
    }

}