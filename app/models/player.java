package models;
import javax.persistence.*;
import java.util.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;
import java.sql.Blob;
@Entity
 public class player extends Model{
   @Id
   public Integer PID;
   	@Column(name="screenID")
   public Integer screenID;
   public String name;
   public String email;
   public Blob pic;
   public Date b_date;
   public String pass;
   public boolean activate;
   @OneToMany(mappedBy = "play")
   public List<team_members> myTeam ;
   public List<team_members> getmyTeam(){
     return myTeam;
   }
   @OneToMany(mappedBy = " rPlayer")
   public ArrayList<reserved_slots> myReserve = new ArrayList<reserved_slots>();
   @OneToMany(mappedBy = "p")
   public ArrayList<sessions> mysessions = new ArrayList<sessions>();
   @OneToMany(mappedBy = "p")
   public ArrayList<activate> active = new ArrayList<activate>();
   @ManyToOne
   @JoinColumn(name = "CID")
   public city c;
   public static Finder <Integer,player> find=new Finder<>(player.class);
 }
