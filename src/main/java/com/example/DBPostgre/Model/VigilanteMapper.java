package com.example.DBPostgre.Model;

public class VigilanteMapper {
    public static mVigilanteDTO toDto(mVigilante vigilante) {
        mVigilanteDTO dto = new mVigilanteDTO();
        dto.setId(vigilante.getId());
        dto.setNombre(vigilante.getNombre());
        dto.setApellido(vigilante.getApellido());
        dto.setTelefono(vigilante.getTelefono());
        dto.setNumDocumento(vigilante.getNum_Documento());
        dto.setTurno(vigilante.getTurno());
        dto.setUsuario(vigilante.getUsuario());
        dto.setAccion(vigilante.isAccion());
        return dto;
    }
}
