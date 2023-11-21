package br.edu.atitus.poo.atitusound.entities;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_playlist")
public class PlaylistEntity extends GenericEntity{

	@Column(name = "public_share")
	private boolean publicshare;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_playlist_music",
					joinColumns = @JoinColumn(name = "playlist_uuid"),
					inverseJoinColumns = @JoinColumn(name = "music_uuid"))
	
	private List<MusicEntity> musics;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="user_uuid", nullable = false)
	private UserEntity user;

	public boolean getPublic_share() {
		return publicshare; 
	}

	public void setPublic_share(boolean public_share) {
		this.publicshare = public_share;
	}

	public List<MusicEntity> getMusics() {
		return musics;
	}

	public void setMusics(List<MusicEntity> musics) {
		this.musics = musics;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
