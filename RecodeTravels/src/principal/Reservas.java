package principal;

import java.util.Date;

public class Reservas {
	 private int IDReserva;
	    private int IDUsuario;
	    private int IDVoo;
	    private Date dataHoraReserva;
	    private String statusReserva;
	    
		public int getIDReserva() {
			return IDReserva;
		}
		public void setIDReserva(int iDReserva) {
			IDReserva = iDReserva;
		}
		public int getIDUsuario() {
			return IDUsuario;
		}
		public void setIDUsuario(int iDUsuario) {
			IDUsuario = iDUsuario;
		}
		public int getIDVoo() {
			return IDVoo;
		}
		public void setIDVoo(int iDVoo) {
			IDVoo = iDVoo;
		}
		public Date getDataHoraReserva() {
			return dataHoraReserva;
		}
		public void setDataHoraReserva(Date dataHoraReserva) {
			this.dataHoraReserva = dataHoraReserva;
		}
		public String getStatusReserva() {
			return statusReserva;
		}
		public void setStatusReserva(String statusReserva) {
			this.statusReserva = statusReserva;
		}
}
