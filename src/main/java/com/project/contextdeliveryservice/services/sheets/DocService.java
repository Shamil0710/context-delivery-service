package com.project.contextdeliveryservice.services.sheets;

import com.google.api.services.docs.v1.Docs;
import com.google.api.services.docs.v1.model.Document;
import com.google.api.services.docs.v1.model.StructuralElement;
import com.project.contextdeliveryservice.services.sheets.utils.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class DocService {
    private final ServiceUtil serviceUtil;

    @Autowired
    public DocService(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    public void docTest() throws GeneralSecurityException, IOException {
        Docs docs = serviceUtil.getDocService();
        Document document = docs.documents().get("155hR5GIqFut8YzTk5J1EG7NwMbw7QvhUdbNgb1dpMZk").execute();
//        List<StructuralElement> response = document.getSuggestionsViewMode();
//
//        response.forEach(resp -> {
//            try {
//                System.out.println(resp.toPrettyString());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
