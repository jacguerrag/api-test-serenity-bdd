package petstore;

public class Pet {
    private String name;
    private String status;
    private Long id;

    public Pet(String name, String status, Long id) {
        this.name = name;
        this.status = status;
        this.id = id;
    }

    public Pet(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
