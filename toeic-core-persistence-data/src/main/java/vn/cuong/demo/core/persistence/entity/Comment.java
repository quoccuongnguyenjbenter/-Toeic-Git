package vn.cuong.demo.core.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentID;
    @Column(name = "content")
    private String content;
    @Column(name = "createddate")
    private String createdDate;
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    @ManyToOne
    @JoinColumn(name = "listenguidelineid")
    private ListenGuideline liseListenGuideline;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ListenGuideline getLiseListenGuideline() {
        return liseListenGuideline;
    }

    public void setLiseListenGuideline(ListenGuideline liseListenGuideline) {
        this.liseListenGuideline = liseListenGuideline;
    }
}
