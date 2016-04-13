package de.creative.musiclib.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Song {

	private final StringProperty songName;
	private final StringProperty author;
	private final StringProperty singer;
	private final StringProperty chordsIntro;
	private final StringProperty chordsRefrain;
	private final StringProperty chordsVerse;
	private final StringProperty chordsBridge;
	private final StringProperty chordsPreRefrain;
	private final IntegerProperty publishYear;
	private final StringProperty tonart;
	private final IntegerProperty kapo;

	/**
	 * Default constructor.
	 */
	public Song() {
		this("", "", "Lars", "", "", 2015, "", "", "", "C", 0);
	}

	/**
	 * Constructor with some initial data.
	 * 
	 * @param pSongName
	 * @param pAuthor
	 */
	public Song(String pSongName, String pAuthor, String pSinger, String pChordsIntro, String pChordsRefrain, int pYear,
			String pChordsBridge, String pChordsPreRefrain, String pChrodsVerse, String pTonart, int pKapo) {
		this.songName = new SimpleStringProperty(pSongName);
		this.author = new SimpleStringProperty(pAuthor);

		// Some initial dummy data, just for convenient testing.
		this.singer = new SimpleStringProperty(pSinger);
		this.chordsIntro = new SimpleStringProperty(pChordsIntro);
		this.chordsRefrain = new SimpleStringProperty(pChordsRefrain);
		this.publishYear = new SimpleIntegerProperty(pYear);
		this.chordsBridge = new SimpleStringProperty(pChordsBridge);
		this.chordsPreRefrain = new SimpleStringProperty(pChordsPreRefrain);
		this.chordsVerse = new SimpleStringProperty(pChrodsVerse);
		this.tonart = new SimpleStringProperty(pTonart);
		this.kapo = new SimpleIntegerProperty(pKapo);
	}

	public String getSongName() {
		return songName.get();
	}

	public void setSongName(String pSongName) {
		this.songName.set(pSongName);
	}

	public StringProperty songNameProperty() {
		return songName;
	}

	public String getAuthor() {
		return author.get();
	}

	public void setAuthor(String pAuthor) {
		this.author.set(pAuthor);
	}

	public StringProperty authorProperty() {
		return author;
	}

	public String getSinger() {
		return singer.get();
	}

	public void setSinger(String pSinger) {
		this.singer.set(pSinger);
	}

	public StringProperty singerProperty() {
		return singer;
	}

	public String getChordsIntro() {
		return chordsIntro.get();
	}

	public void setChordsIntro(String pChordsIntro) {
		this.chordsIntro.set(pChordsIntro);
	}

	public StringProperty chordsIntroProperty() {
		return chordsIntro;
	}

	public String getChordsVerse() {
		return chordsVerse.get();
	}

	public void setChordsVerse(String pChordsVerse) {
		this.chordsVerse.set(pChordsVerse);
	}

	public StringProperty chordsVerseProperty() {
		return chordsVerse;
	}

	public String getChordsBridge() {
		return chordsBridge.get();
	}

	public void setChordsBridge(String pChordsBridge) {
		this.chordsBridge.set(pChordsBridge);
	}

	public StringProperty chordsBridgeProperty() {
		return chordsBridge;
	}

	public String getChordsPreRefrain() {
		return chordsPreRefrain.get();
	}

	public void setChordsPreRefrain(String pChordsPreRefrain) {
		this.chordsPreRefrain.set(pChordsPreRefrain);
	}

	public StringProperty chordsPreRefrainProperty() {
		return chordsPreRefrain;
	}

	public String getChordsRefrain() {
		return chordsRefrain.get();
	}

	public void setChordsRefrain(String pChordsRrefrain) {
		this.chordsRefrain.set(pChordsRrefrain);
	}

	public StringProperty chordsRefrainProperty() {
		return chordsRefrain;
	}

	public String getTonart() {
		return tonart.get();
	}

	public void setTonart(String pTonart) {
		this.tonart.set(pTonart);
	}

	public StringProperty tonartProperty() {
		return tonart;
	}
	
	public int getKapo() {
		return kapo.get();
	}

	public void setKapo(int pKapo) {
		this.kapo.set(pKapo);
	}

	public IntegerProperty kapoProperty() {
		return kapo;
	}

	public int getPublishYear() {
		return publishYear.get();
	}

	public void setPublishYear(int pYear) {
		this.publishYear.set(pYear);
	}

	public IntegerProperty publishYearProperty() {
		return publishYear;
	}
}