package org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.Repository;

import java.util.List;

import org.anbin_aravaippu_arakkattali.Anbin.Aravanaippu.Arakkattalai.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	@Query(value = "select m from Message m order by m.messageId desc limit 5 ")
	List<Message> findLastMessages();

	@Query(value = "select m from Message m where m.createdAt like  ?1 ")
	List<Message> findTodayMessages(String date);

}
