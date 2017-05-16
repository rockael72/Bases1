use bdAlquiler3;


-- trigger tblmercaderia 
delimiter //
drop trigger if exists insertarMercaderia //

create trigger insertarMercaderia
before insert on tblMercaderia
for each row
begin
	set new.Reservados =0;
    set new.Cantidad = 0;
    set new.Disponibles = 0;
end;//
delimiter ;

-- triger tbldetallecompra
delimiter //
drop trigger if exists detalle1 //

create trigger detalle1
before insert on tblDetalleCompra
for each row
begin
	set new.Fecha = now();    
    update tblMercaderia 
    set tblMercaderia.Cantidad = tblMercaderia.Cantidad + new.Cantidad,
	tblMercaderia.Disponibles = tblMercaderia.Disponibles + new.Cantidad
    where tblMercaderia.id = new.tblMercaderia_id; 
end;//
delimiter ;


-- trigger tblDetalle
delimiter //
drop trigger if exists disponibles //

create trigger disponibles
before insert on tblDetalle
for each row
begin
	set new.Fecha = now();
	set new.Defectuoso = 0;
    set new.PrecioDefectuoso = 0;
    
	update tblMercaderia 
    set tblMercaderia.Disponibles = tblMercaderia.Disponibles - new.Cantidad,
    tblMercaderia.Reservados = tblMercaderia.Reservados + new.Cantidad
    
    where tblMercaderia.id = new.tblMercaderia_id; 
end; //
delimiter ;


-- trigger tblDetalle
delimiter //
drop trigger if exists regresar //

create trigger regresar
before delete on tblDetalle
for each row
begin
	update tblMercaderia 
    set tblMercaderia.Disponibles = tblMercaderia.Disponibles + old.Cantidad,
    tblMercaderia.Reservados = tblMercaderia.Reservados - old.Cantidad    
    where tblMercaderia.id = old.tblMercaderia_id; 
end; //
delimiter ;


-- trigger tblReservacion
delimiter //
drop trigger if exists iniciar //

create trigger inicar
before insert on tblReservacion
for each row
begin
	set new.Saldo=0;
    set new.Total=0;
    set new.Activo=1;
    set new.Anulado=false;
end;//
delimiter ;


-- trigger tblReservacion 
delimiter //
drop trigger if exists cancelarR //

create trigger cancelarR
before update on tblReservacion
for each row
begin	    
    if ((new.Anulado=true)and(old.Anulado=false)and (old.FechaF is null))then
		call retornar(old.id);		
    end if;
    
    if((old.FechaF is null)and(new.FechaF is not null))then
		set new.FechaF = now();
        call retornar(old.id);
    end if;	
    
end;//
delimiter ;

-- triigger tblPAos
delimiter //
drop trigger if exists npagos //

create trigger npagos
before insert on tblPagos
for each row	
begin
	update tblReservacion 
    set tblReservacion.Saldo=new.Cuota+tblReservacion.Saldo
    where tblReservacion.id=new.tblReservacion_id;
end; //

delimiter ;





