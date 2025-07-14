package examples.ex_board.ex8.model.dto;

public class BoardDto {
    private String content;
    private String writer;

    public BoardDto() {
    }

    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
