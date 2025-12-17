package me.jgy.w2.service;

import lombok.extern.log4j.Log4j2;
import me.jgy.w2.dao.MemberDAO;
import me.jgy.w2.domain.MemberVO;
import me.jgy.w2.dto.MemberDTO;
import me.jgy.w2.util.MapperUtil;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws SQLException {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }

    public void updateUuid(String mid, String uuid) throws SQLException {
        dao.updateUuid(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws SQLException {
        MemberVO vo = dao.selectUUID(uuid);

        MemberDTO memberDTO = modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
}
