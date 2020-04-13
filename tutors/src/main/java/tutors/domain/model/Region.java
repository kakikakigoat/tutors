package tutors.domain.model;

import java.io.Serializable;


import javax.persistence.*;
import java.util.*;

@Entity
@NamedQuery(name="Region.findAll", query="SELECT r FROM Region r")
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="region_id")
    private int regionId;

    @Column(name="region_name")
    private String regionName;

    //bi-directional many-to-one association to User
    @OneToMany(mappedBy="region")
    private List<User> users;
    
    @OneToMany(mappedBy="region")
    private List<Matching> matchings;

    public Region() {
    }

    public int getRegionId() {
        return this.regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    public List<Matching> getMatchings() {
        return this.matchings;
    }
    
    public void setMatchings(List<Matching> matchings) {
        this.matchings = matchings;
    }
    public Matching addMatching(Matching matching) {
        getMatchings().add(matching);
        matching.setRegion(this);

        return matching;
    }

    public Matching removeMatching(Matching matching) {
        getMatchings().remove(matching);
        matching.setRegion(null);

        return matching;
    }

    public User addUser(User user) {
        getUsers().add(user);
        user.setRegion(this);

        return user;
    }

    public User removeUser(User user) {
        getUsers().remove(user);
        user.setRegion(null);

        return user;
    }

}