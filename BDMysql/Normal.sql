use bdAlquiler;

insert into tblUsuario(Nombre,Usuario,Contrasenia,Administrador)
values ("D","D","54648",true);

select * from tblReservacion 
where Saldo=abs(2020.35);

select * from tblReservacion;

select * from tblReservacion;
SELECT * FROM  tblReservacion WHERE Saldo = 2020.35 or Saldo like 2020.35 and Total like 5000.0 
or Total = 5000
and FechaF='2017-05-15' and Direccion='Direccion de reservacin';

select * from tblMercaderia;

select * from tblCliente;

select * from tblProveedores;

select * from tblCompras;

select * from tblPagos;

select * from tblUsuario;
select Nombre from tblUsuario where id = 1;

select * from tblMercaderia ;

select * from tbldetalle;

select id from tblDetalle where tblReservacion_id=6 and tblMercaderia_id=3 and precio=50 and cantidad=12;

select * from tblMercaderia;

update tblMercaderia set Cantidad =100, Disponibles=100, Reservados=0
where id = 1;

select * from tblTelefono;

select Etiqueta from tblTelefono;

update tblTelefono set Telefono='121213345' where tblCliente_id=1 and Telefono = '11223344';

select * from tblEtiqueta;

select Telefono, Etiqueta from tblProveedores
left join tblTelefono
on tblProveedores.id=tblTelefono.tblProveedores_id
left join tblEtiqueta
on tblEtiqueta.id=tblTelefono.tblEtiqueta_id
where tblProveedores.id=1;


select tblMercaderia.Nombre, tblCategoria.Categoria,
tblMaterial.Material,tblColor.Color,tblTamanio.Tamanio,
tblDetalle.Cantidad,tblDetalle.Precio,tblDetalle.Fecha
from tblReservacion
inner join tblDetalle
on tblReservacion.id=tblDetalle.tblReservacion_id
inner join tblMercaderia 
on tblDetalle.tblMercaderia_id=tblMercaderia.id
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
where tblDetalle.tblReservacion_id=1;