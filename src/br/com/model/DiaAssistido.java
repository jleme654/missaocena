package br.com.model;

import java.sql.Timestamp;

/**
 *
 * @since 18/10/201
 * @author jleme
 */
public class DiaAssistido {

	private int idAssistido;
	private Timestamp diaVisita;

	public int getIdAssistido() {
		return idAssistido;
	}

	public void setIdAssistido(int idAssistido) {
		this.idAssistido = idAssistido;
	}

	public Timestamp getDiaVisita() {
		return diaVisita;
	}

	public void setDiaVisita(Timestamp diaVisita) {
		this.diaVisita = diaVisita;
	}

}