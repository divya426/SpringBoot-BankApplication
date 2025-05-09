package impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.IAccountService;
import com.example.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements IAccountService {

	
	private IAccountRepository accRepo;
	
	@Autowired
	public AccountServiceImpl(IAccountRepository accRepo) {
		this.accRepo=accRepo;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accRepo.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccount(Long id) {
		Account account=accRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Account does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}

	
	@Override
	public AccountDto deposit(Long id, Double amount) {
		
		Account account= accRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Account does not exist"));

		Double newAmount= account.getBalance()+amount;
		account.setBalance(newAmount);
		 Account savedAccount = accRepo.save(account);
		return AccountMapper.mapToAccountDto(account);
	}

}
