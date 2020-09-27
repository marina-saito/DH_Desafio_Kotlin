package br.digital.com

class DigitalHouseManager(
        var listaAlunos: MutableMap<Int,Aluno>,
        var listaProfessores: MutableMap<Int,Professor>,
        var listaCursos: MutableMap<Int,Curso>,
        var listaMatriculas: MutableSet<Matricula>) {

    fun registrarCurso(nomeCurso: String, codigoCurso: Int, qtdMaxAlunos: Int){
        if (codigoCurso in listaCursos) println("Este código de curso já existe!")
        else {
            var cursoNovo = Curso(nomeCurso, codigoCurso, qtdMaxAlunos)
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
            var novoProfAdjunto = ProfessorAdjunto(nomeProfessor, sobrenomeProfessor, 0, codigoProfessor, qtdHoras)
            listaProfessores.put(codigoProfessor, novoProfAdjunto)
            println("Professor adjunto cadastrado com sucesso!")
        }
    }

    fun registrarProfessorTitular(nomeProfessor: String , sobrenomeProfessor: String, codigoProfessor: Int, especialidade: String){
        if (codigoProfessor in listaProfessores) println("Este código de professor já existe!")
        else {
            var novoProfTitular = ProfessorTitular(nomeProfessor, sobrenomeProfessor, 0, codigoProfessor, especialidade)
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

    fun registrarAluno(nomeAluno: String, sobrenomeAluno: String, codigoAluno: Int){
        if (codigoAluno in listaAlunos) println("Este código de aluno já existe!")
        else {
            var novoAluno = Aluno(nomeAluno, sobrenomeAluno, codigoAluno)
            listaAlunos.put(codigoAluno, novoAluno)
            println("Aluno cadastrado com sucesso!")
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int){
        if (codigoAluno in listaAlunos && codigoCurso in listaCursos && listaCursos.count() < listaCursos[codigoCurso]!!.maxAlunos) {
            var novaMatricula = Matricula(listaAlunos[codigoAluno], listaCursos[codigoCurso])
            listaMatriculas.add(novaMatricula)
            println("Matrícula realizada com sucesso!")
        }
        else if (codigoAluno in listaAlunos && codigoCurso in listaCursos && listaCursos.count() == listaCursos[codigoCurso]!!.maxAlunos) {
            println("Não foi possível realizar a matrícula. Não há vagas disponíveis!")
        }
        else println("Codigo de aluno ou curso não encontrado!")
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int){
        if(codigoCurso in listaCursos && codigoProfessorTitular in listaProfessores && codigoProfessorAdjunto in listaProfessores) {
            listaCursos[codigoCurso]!!.professorTitular = listaProfessores[codigoProfessorTitular] as ProfessorTitular
            listaCursos[codigoCurso]!!.professorAdjunto = listaProfessores[codigoProfessorAdjunto] as ProfessorAdjunto

        }
    }
    
}