package de.creative.musiclib.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Helper class to wrap a list of persons. This is used for saving the list of
 * persons to XML.
 * 
 */
@XmlRootElement(name = "songs")
public class SongListWrapper {

	private List<Song> songs;
	private List<Block> blocks;

	@XmlElement(name = "song")
	public List<Song> getSongs() {
		return songs;
	}
	@XmlElement(name = "block")
	public List<Block> getBlocks() {
		return blocks;
	}


	public void setSongs(List<Song> pSongs) {
		this.songs = pSongs;
	}
	public void setBlocks(List<Block> pBlocks) {
		this.blocks = pBlocks;
	}
}