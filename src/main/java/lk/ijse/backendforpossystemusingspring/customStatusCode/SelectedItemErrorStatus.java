package lk.ijse.backendforpossystemusingspring.customStatusCode;

import lk.ijse.backendforpossystemusingspring.dto.CustomerStatus;
import lk.ijse.backendforpossystemusingspring.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedItemErrorStatus implements ItemStatus {
    private int statusCode;
    private String statusMessage;
}
