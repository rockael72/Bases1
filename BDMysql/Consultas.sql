use bdAlquiler;

select tblUsuario.Nombre, tblCliente.Nombre, tblCliente.Apellido,
tblCliente.DPI, tblTelefono.Telefono,
tblReservacion.Direccion, tblReservacion.FechaR
from tblCliente
inner join tblReservacion
on tblCliente.id = tblReservacion.tblCliente_id
inner join tblUsuario
on tblUsuario.id=tblReservacion.tblUsuario_id
inner join tblTelefono
on tblCliente.id=tblTelefono.tblCliente_id
where FechaR > '2017-05-15' and tblReservacion.Anulado = false
group by tblReservacion.id
order by tblReservacion.FechaR;

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
on tblTamanio_id=tblTamanio.id;


select tblUsuario.Nombre, tblCliente.Nombre, tblCliente.Apellido,
tblCliente.DPI, tblTelefono.Telefono,
tblReservacion.Direccion, tblReservacion.FechaR, Saldo, Total
from tblCliente
inner join tblReservacion
on tblCliente.id = tblReservacion.tblCliente_id
inner join tblUsuario
on tblUsuario.id=tblReservacion.tblUsuario_id
inner join tblTelefono
on tblCliente.id=tblTelefono.tblCliente_id
where Total>Saldo and tblReservacion.Anulado = false;
