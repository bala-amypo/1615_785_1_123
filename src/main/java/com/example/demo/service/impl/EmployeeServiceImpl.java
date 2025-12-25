@Override
public Employee getEmployeeById(Long id) {
    return repo.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Employee not found"));
}

@Override
public List<Employee> getAllEmployees() {
    return repo.findAll();
}
