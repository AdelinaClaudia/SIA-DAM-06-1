package org.app.service.ejb;
import javax.ejb.Remote;

import org.app.service.entities.*;
@Remote
public interface ContracteAngajatDataService {
Contract createnewContract(Integer nrContract);
Angajat getAngajatbyMarca(Integer marcaA);
String getMessage();
}