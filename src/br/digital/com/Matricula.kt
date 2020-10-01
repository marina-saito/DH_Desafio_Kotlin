package br.digital.com

import java.util.*

class Matricula(var aluno: Aluno, var curso: Curso, var dataMatricula: Date = Date()) {

    override fun toString(): String {
        return "Matricula(aluno=${aluno.nomeAluno}, curso=${curso.nomeCurso})"
    }
}