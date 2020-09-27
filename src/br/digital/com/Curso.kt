package br.digital.com

class Curso(
        var nomeCurso: String,
        var codigoCurso: Int,
        var maxAlunos: Int,
        var listaAlunos: MutableList<Aluno> = mutableListOf()) {

    lateinit var professorTitular: ProfessorTitular
    lateinit var professorAdjunto: ProfessorAdjunto

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Curso

        if (codigoCurso != other.codigoCurso) return false

        return true
    }

    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        if (maxAlunos == listaAlunos.lastIndex + 1) return false
        else listaAlunos.add(umAluno)
        return true
    }

    fun excluirAluno(umAluno: Aluno) {
        listaAlunos.remove(umAluno)
    }

}