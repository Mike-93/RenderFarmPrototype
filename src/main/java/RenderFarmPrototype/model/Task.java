package RenderFarmPrototype.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "users_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "render_status")
    private RenderStatus renderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "create_time", nullable = false)
    @NotNull
    private Date createTime = new Date();


}
