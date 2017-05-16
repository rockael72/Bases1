use bdAlquiler2;

delimiter //
drop procedure if exists producto //

create procedure producto(vnombre varchar(30))
begin
select Nombre,Categoria,Tipo,Material,Color,Tamanio from tblMercaderia
inner join tblCategoria
on tblMercaderia.tblCategoria_id = tblCategoria.id
inner join tblTipo
on tblMercaderia.tblTipo_id = tblTipo.id
inner join tblMaterial
on tblMaterial_id=tblMaterial.id
inner join tblColor
on tblColor_id=tblColor.id
inner join tblTamanio
on tblTamanio_id=tblTamanio.id
where upper(nombre) = upper(vnombre) collate utf8_bin;
end; //
delimiter ;

delimiter //
drop procedure if exists productoPrecio //

create procedure productoPrecio(vnombre varchar(30))
begin 
select Nombre,Categoria,Tipo,Material,Color,Tamanio as Tamaño, Cantidad, Reservados, Disponibles, Precio from tblMercaderia
inner join tblCategoria
on tblMercaderia.tblCategoria_id = tblCategoria.id
inner join tblTipo
on tblMercaderia.tblTipo_id = tblTipo.id
inner join tblMaterial
on tblMaterial_id=tblMaterial.id
inner join tblColor
on tblColor_id=tblColor.id
inner join tblTamanio
on tblTamanio_id=tblTamanio.id
where upper(nombre) = upper(vnombre) collate utf8_bin;

end ; //
delimiter ;


delimiter //
drop procedure if exists detalleR //

create procedure detalleR(vid int)
begin
end;//
delimiter ;

delimiter //
drop procedure if exists retornar //

create procedure retornar(vid int)
begin
	declare cont int default 0;
	declare vidM int ;
    declare vPrecio float;
    declare vCantidad int;
    
    
    declare micursor cursor for
    select  tblMercaderia_id, Precio, Cantidad
    from tblDetalle 
    where tblDetalle.tblReservacion_id=vid;

    declare continue handler
    for sqlstate '02000' set cont=1;
    
    open micursor;
    fetch micursor into vidM, vPrecio, vCantidad;
    while(cont=0)do
		update tblMercaderia 
		set tblMercaderia.Disponibles = tblMercaderia.Disponibles + vCantidad,
		tblMercaderia.Reservados = tblMercaderia.Reservados - vCantidad    
		where tblMercaderia.id = vidM; 
		fetch micursor into vidM, vPrecio, vCantidad;
    end while;
    
    
end;//

delimiter ;




