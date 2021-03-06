package carros.com.br.crecheepreescola.interfacce;

import java.util.List;


import carros.com.br.crecheepreescola.dominio.Aluno;
import carros.com.br.crecheepreescola.dominio.Diario;
import carros.com.br.crecheepreescola.dominio.Pessoa;
import carros.com.br.crecheepreescola.dominio.Turma;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IRetrofitCreche {

    @POST("Diario/inserir")
    Call <Boolean> postDiario(@Body Diario diario);

    @GET("Diario/diarioAluno/{idAluno},{idResponsavel}")
    Call <Diario> getDiarios(@Path("idAluno") int idAluno, @Path("idResponsavel") int idResponsavel );

    @GET("Turma/listar/{idProfessor}")
    Call <List<Turma>> getTurmas(@Path("idProfessor") int idProfessor);

    @GET("Alunos/listarPorTurma/{idTurma}")
    Call <List<Aluno>> getAlunos(@Path("idTurma") int idTurma);

    @GET("Alunos/listarPorResponsavel/{idResponsavel}")
    Call <List<Aluno>> getAlunosResponsavel(@Path("idResponsavel") int idResponsavel);

    @GET("Pessoa/login/{email},{senha}")
    Call<Pessoa> login(@Path("email") String email, @Path("senha") String senha);


//    @GET("Estado/listar")
//    Call <List<Estado>> getEstados();
//

//    //@GET("Pessoa/verificaLogin/{email},{senha}")
//    //Call<Boolean> verificaLogin(@Path("email") String email, @Path("senha") String senha);
//
//
//    @GET("TipoTurma/listarPorProfessor/{id}")
//    Call <List<TipoTurma>> getTipoTurmaProfessor(@Path("id") int id);
//
//    @GET("Alunos/listarAlunos/{id}")
//    Call <List<Aluno>> getListarAlunos(@Path("id") int id);
//
//    @GET("Alunos/listarAlunosPresentes/{id}")
//    Call <List<AlunoPresenca>> getAlunosPresentesId(@Path("id") int id);
//
//    @GET("Pessoa/listar")
//    Call <List<Pessoa>> getPessoas();


    /*(@Path("estados") String estados);
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();*/
}
