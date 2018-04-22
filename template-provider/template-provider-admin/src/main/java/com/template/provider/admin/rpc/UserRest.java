package com.template.provider.admin.rpc;

import com.template.auth.common.bean.PermissionInfo;
import com.template.auth.common.bean.UserInfo;
import com.template.provider.admin.rpc.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Create By Project template
 *
 * @author zrb
 * @date 2018/4/22
 * description
 */
@RestController
@RequestMapping("api")
public class UserRest {

    @Autowired
    private PermissionService permissionService;

    //@Cache(key="permission")
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public @ResponseBody
    List<PermissionInfo> getAllPermission(){
        return null;
    }

    //@Cache(key="permission:u{1}")
    @RequestMapping(value = "/user/un/{username}/permissions", method = RequestMethod.GET)
    public @ResponseBody List<PermissionInfo> getPermissionByUsername(@PathVariable("username") String username){
        return null;
    }

    @RequestMapping(value = "/user/validate", method = RequestMethod.POST)
    public @ResponseBody
    UserInfo validate(@RequestBody Map<String,String> body){
        return permissionService.validate(body.get("username"),body.get("password"));
    }

}
