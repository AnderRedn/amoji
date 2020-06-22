package datos;

import java.util.List;

import modelo.Emoji;


public interface IEmojiDAO {
	void createEmoji(Emoji p);
	List<Emoji> listEmojis();
	Emoji getEmojiById(int idEmoticon);
	List<Emoji> getEmojisByType(int idType);
	void deleteEmoji(int idEmoticon);
	void updateEmoji(Emoji p);
}
