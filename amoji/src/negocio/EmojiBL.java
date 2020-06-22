package negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.JDBCEmojiDAO;
import modelo.Emoji;

@Service
public class EmojiBL {
	
	@Autowired
	JDBCEmojiDAO dao;
	
	public void createEmoji(Emoji e){
		dao.createEmoji(e);
	}
	
	public List<Emoji> listEmojis(){
		return dao.listEmojis();
	}
	
	public void deleteEmoji(int id){
		dao.deleteEmoji(id);
	}
	
	
	public void updateEmoji(Emoji e){
		dao.updateEmoji(e);
	}
	
	public Emoji getEmojiById(int id){
		return dao.getEmojiById(id);
	}
	
	public List<Emoji> getEmojisByType(int id){
		return dao.getEmojisByType(id);
	}
	
}
