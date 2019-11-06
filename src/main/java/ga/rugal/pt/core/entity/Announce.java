package ga.rugal.pt.core.entity;

import static config.SystemDefaultProperty.SCHEMA;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * Announce entity.
 *
 * @author Rugal Bernstein
 */
@Data
@Entity
@Table(name = "announce", schema = SCHEMA)
public class Announce {

  private static final String SEQUENCE_NAME = "announce_aid_seq";

  @Basic(optional = false)
  @Column
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
                     sequenceName = SCHEMA + "." + SEQUENCE_NAME)
  private Integer aid;

  @Column
  private Long download;

  @Column
  private Long upload;

  @Column(name = "create_time")
  private Long createTime;

  @Column(name = "update_time")
  private Long updateTime;

  @JoinColumn(name = "client", referencedColumnName = "cid")
  @ManyToOne
  private Client client;

  @JoinColumn(name = "post", referencedColumnName = "pid")
  @ManyToOne
  private Post post;

  @JoinColumn(name = "user", referencedColumnName = "uid")
  @ManyToOne
  private User user;
}
