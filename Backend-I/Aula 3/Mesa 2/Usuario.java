package aula3_1;

public class Usuario {
    private String nome;
    private int id;
    private String tipoUsuario;

    public Usuario(String nome, int id, String tipoUsuario){
        this.nome = nome;
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
