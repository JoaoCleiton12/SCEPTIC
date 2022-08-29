package model;
import java.sql.SQLException;
public class InsertException extends SQLException {
  public InsertException(String recebido) {
		System.out.println(recebido);
	}
}
