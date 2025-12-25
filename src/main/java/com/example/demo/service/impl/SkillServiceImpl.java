@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        skill.setActive(true);
        return repo.save(skill);
    }

    @Override
    public Skill deactivateSkill(long id) {
        Skill skill = repo.findById(id).orElseThrow();
        skill.setActive(false);
        return repo.save(skill);
    }
}
