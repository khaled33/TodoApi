package com.sid.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TodoService implements TodoServiceI {

    @Autowired
    private TodoReposirory todoReposirory;

    @Override
    public List<Todo> getAllTodo() {
        return virifeStatus(todoReposirory.findAll());
    }

    @Override
    public Todo getByIdTodo(Long id) {
        return todoReposirory.getOne(id);
    }

    @Override
    public Todo AddTodo(Todo todo) {
        return todoReposirory.save(todo);
    }

    @Override
    public Todo ModifeTodo(Todo todo) {

        return todoReposirory.save(todo);
    }

    @Override
    public void DeleteTodo(Long id) {
        todoReposirory.deleteById(id);
    }

    @Override
    public void changerStatus(String Status, Long id) {
        Todo todo = todoReposirory.getOne(id);
        todo.setStatus(Status);
        todo.setCheckd("yes");
        todoReposirory.save(todo);

    }

    private List<Todo> virifeStatus(List<Todo> todos) {

        for (Todo todo : todos) {
            Date dataDebut = todo.getDateDebut();
            Date echeance = todo.getEcheance();
            Date dateFin = todo.getDatefin();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
            Date dateNow = new Date(System.currentTimeMillis());

//            *****************Ouvert && Cours ************************

            int diff0;
            int diff1 = dateNow.compareTo(echeance);
            int diff = dataDebut.compareTo(dateNow);
            if (dateFin != null) {
                diff0 = dateNow.compareTo(dateFin);


                int diff2 = echeance.compareTo(dateFin);
                if (diff0 > 0) {
                    todo.setStatus(String.valueOf(Status.TerminerRetard));

                } else {
                    if (diff > 0) {
                        todo.setStatus(String.valueOf(Status.Ouvert));

                    } else todo.setStatus(String.valueOf(Status.Cours));

                    if (diff1 > 0 || todo.getCheckd().equals("yes")) {
                        todo.setStatus(String.valueOf(Status.complété));


                    }

                    if (diff2 > 0) {
                        todo.setStatus(String.valueOf(Status.complété));

                    }

                }
//            else   {
//
//
//
//
//
////            *****************Coplite************************
//             int diff2 = echeance.compareTo(dateFin);
//            if(diff2 > 0) {
//                todo.setStatus(String.valueOf(Status.complété));
//
//            }
//            //            *****************retard************************
//            int diff3 = echeance.compareTo(dateNow);
//            if (diff3 > 0 && dateFin==null ) {
//                todo.setStatus(String.valueOf(Status.Retard));
//
//            }
//
//            //            *****************TerminerRetard************************
//            int diff4 = dateFin.compareTo(echeance);
//            int diff5 = dateFin.compareTo(dateNow);
//            if (diff4 < 0 && diff5<0 ) {
//                todo.setStatus(String.valueOf(Status.TerminerRetard));
//
//            }
//
//            }
            } else {
                if (diff1 > 0) {
                    System.out.println("kkkkkkkkkkkkk");
                    todo.setStatus(String.valueOf(Status.Retard));
                } else if (diff > 0) {
                    todo.setStatus(String.valueOf(Status.Ouvert));
                } else {
                    if (todo.getCheckd().equals("yes"))
                        todo.setStatus(String.valueOf(Status.complété));
                    else
                        todo.setStatus(String.valueOf(Status.Cours));
                }

            }

            ModifeTodo(chargerClassColor(todo));
        }

        return todos;
    }

    private Todo chargerClassColor(Todo todo) {

        if (todo.getStatus().equals(String.valueOf(Status.Ouvert))) {
            todo.setClassColor("badge badge-info");
        } else if (todo.getStatus().equals(String.valueOf(Status.Cours))) {
            todo.setClassColor("badge badge-warning");


        } else if (todo.getStatus().equals(String.valueOf(Status.complété))) {
            todo.setClassColor("badge badge-success");


        } else if (todo.getStatus().equals(String.valueOf(Status.Retard))) {
            todo.setClassColor("badge badge-danger");


        } else if (todo.getStatus().equals(String.valueOf(Status.TerminerRetard))) {
            todo.setClassColor("badge badge-secondary");

        }
        return todo;
    }
    @Override
    public DtoStatsc stat(){
        DtoStatsc dtoStatsc=new DtoStatsc();

        dtoStatsc.setOuvert(todoReposirory.countByStatus("Ouvert"));
        dtoStatsc.setCours(todoReposirory.countByStatus("Cours"));
        dtoStatsc.setRetard(todoReposirory.countByStatus("Retard"));
        dtoStatsc.setComplete(todoReposirory.countByStatus("complété"));
        dtoStatsc.setTerminerRetard(todoReposirory.countByStatus("TerminerRetard"));


        return dtoStatsc;
    }
}
