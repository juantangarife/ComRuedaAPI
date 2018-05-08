package model.eventos.salidas;

import model.eventos.Evento;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salidas")
public class Salida extends Evento {
}
