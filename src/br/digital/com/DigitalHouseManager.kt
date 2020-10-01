package br.digital.com

class DigitalHouseManager(
        var listaAlunos: MutableMap<Int,Aluno> = mutableMapOf(),
        var listaProfessores: MutableMap<Int,Professor> = mutableMapOf(),
        var listaCursos: MutableMap<Int,Curso> = mutableMapOf(),
        var listaMatriculas: MutableSet<Matricula> = mutableSetOf()
){

    fun registrarCurso(nomeCurso: String, codigoCurso: Int, qtdMaxAlunos: Int){
        if (codigoCurso in listaCursos) println("Este código de curso já existe!")
        else {
            val cursoNovo = Curso(nomeCurso, codigoCurso, qtdMaxAlunos)
            listaCursos.put(codigoCurso, cursoNovo)
            println("Curso cadastrado com sucesso!")
        }
    }

    fun excluirCurso(codigoCurso: Int){
        if (codigoCurso in listaCursos) {
            listaCursos.remove(codigoCurso)
            println("Curso excluído com sucesso!")
        }
        else println("Este código de curso não existe!")
    }

    fun registrarProfessorAdjunto(nomeProfessor: String , sobrenomeProfessor: String , codigoProfessor: Int, qtdHoras: Int){
        if (codigoProfessor in listaProfessores) println("Este código de professor já existe!")
        else {
            val novoProfAdjunto = ProfessorAdjunto(nomeProfessor, sobrenomeProfessor, 0, codigoProfessor, qtdHoras)
            listaProfessores.put(codigoProfessor, novoProfAdjunto)
            println("Professor adjunto cadastrado com sucesso!")
        }
    }

    fun registrarProfessorTitular(nomeProfessor: String , sobrenomeProfessor: String, codigoProfessor: Int, especialidade: String){
        if (codigoProfessor in listaProfessores) println("Este código de professor já existe!")
        else {
            val novoProfTitular = ProfessorTitular(nomeProfessor, sobrenomeProfessor, 0, codigoProfessor, especialidade)
            listaProfessores.put(codigoProfessor, novoProfTitular)
            println("Professor titular cadastrado com sucesso!")
        }
    }

    fun excluirProfessor(codigoProfessor: Int){
        if (codigoProfessor in listaProfessores) {
            listaProfessores.remove(codigoProfessor)
            println("Professor excluído com sucesso!")
        }
        else println("Este código de professor não existe!")
    }

    fun matricularAluno(nomeAluno: String, sobrenomeAluno: String, codigoAluno: Int){
        if (codigoAluno in listaAlunos) println("Este código de aluno já existe!")
        else {
            val novoAluno = Aluno(nomeAluno, sobrenomeAluno, codigoAluno)
            listaAlunos.put(codigoAluno, novoAluno)
            println("Aluno cadastrado com sucesso!")
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        if (codigoAluno in listaAlunos && codigoCurso in listaCursos) {
            if (with (listaCursos.getValue(codigoCurso)) { listaAlunos.size < maxAlunos }) {
                val novaMatricula = Matricula(listaAlunos.getValue(codigoAluno), listaCursos.getValue(codigoCurso))
                listaMatriculas.add(novaMatricula)
                listaCursos.getValue(codigoCurso).listaAlunos.add(listaAlunos.getValue(codigoAluno))
                println("Matrícula realizada com sucesso! Número de alunos nesse curso: ${listaCursos.getValue(codigoCurso).listaAlunos.size}")
            }
            else println("Não foi possível realizar a matrícula. Não há vagas disponíveis!")
        }
        else println("Codigo de aluno ou curso não encontrado!")
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        when (codigoCurso in listaCursos && codigoProfessorTitular in listaProfessores && codigoProfessorAdjunto in listaProfessores) {
            true && true && true -> {
                with (listaCursos.getValue(codigoCurso)) {
                    professorTitular = listaProfessores[codigoProfessorTitular] as ProfessorTitular
                    professorAdjunto = listaProfessores[codigoProfessorAdjunto] as ProfessorAdjunto
                }
                println("Professores alocados com sucesso!")
            }
            false && true && true -> println("Código de curso inválido!")
            true && false && true -> println("Código de professor titular inválido!")
            true && true && false -> println("Código de professor adjunto inválido!")
        }
    }

    fun consultaMatricula(codigoAluno: Int) {
        if (codigoAluno in listaAlunos) {
            val listaCursosDesseAluno: MutableList<String> = mutableListOf()
            listaMatriculas.forEach { if (it.aluno.codigoAluno == codigoAluno) listaCursosDesseAluno.add(it.curso.nomeCurso) }
            println("Olá ${listaAlunos.getValue(codigoAluno).nomeAluno}! Você está matriculado nesse(s) curso(s): ${listaCursosDesseAluno}")
        }
        else println("Código de aluno inválido")
    }

}